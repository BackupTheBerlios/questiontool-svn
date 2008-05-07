<?php
//Lade die Einstellunges des Datenbankservers
include "config.php";

$verbindung = mssql_connect(MSSQL_HOST, MSSQL_USER, MSSQL_PASS) OR die("Es konnte keine Verbindung zur Datenbank hergestellt werden.");
;

while ($verbindung == false) {
	$verbindung = mssql_connect(MSSQL_HOSTs, MSSQL_USER, MSSQL_PASS);
}
mssql_select_db(MSSQL_DATABASE) OR die("Die Datenbank konnte nicht ausgewählt werden");

$TAN = $_POST['TAN'];
echo "Folgende Daten wurden übermittelt:";
echo "<table>";

//es wird eine Liste erzeugt mit schlüssel und wert. Über eine Schleife
while (list ($key, $val) = each($_POST)) {
	//echo "$key => $val<br>";

	$test = "a";
	$test = $val;
//Die ersten 5 Buchstaben unterscheiden die Fragetypen
	$wert = substr($key, 0, 5);
//Wenn der Typ 'Checkbox' ist
	if ($wert == "Check") {

		$ausstattung = $_POST[$key]; //Inhalt der Checkboxen
		//in der Variable ausstattung stehen alle ausgewählten Antworten als Array. Dieses Array wird mithilfe einer foreach Schleife durchgegangen
		foreach ($ausstattung as $value) {
	//Es wird in der Tabelle 'gegebeneAntwort' geschrieben. Es werden nur die 2 Spalten GA_A_ID und GA_T_ID ausgefüllt.
			$sql = "INSERT INTO gegebeneAntwort
											                (GA_A_ID, GA_T_ID)
											            VALUES
											                (" . "$value" . ",
											                " . $_POST['TAN'] . ")";
			$result = @ mssql_query($sql) OR die("fehler beim check");
			$sql = "SELECT Distinct * from ausw where A_ID=$value";
			$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
			$stop = 0;
			$antwort = 0;
//gibt die Eingabe am Bildschirm aus
			while ($row2 = mssql_fetch_assoc($result)) {
				if ($antwort == 0) {
					echo "<tr><td>" . $row2['F_Frage'] . "</td>";
					echo "<td>" . $row2['A_Antwort'] . "</td></tr>";
					$antwort = 2;
				}
			}

		}

	}
//ob der Antworttyp Radio oder Dropdown ist, spielt keine Rolle, weil sie gleich aufgebaut sind.
//
	if (($wert == "Radio") OR ($wert == "Dropd")) {
		$sql = "INSERT INTO gegebeneAntwort
										                (GA_A_ID, GA_T_ID)
										            VALUES
										                (" . "$val" . ",
										                " . $_POST['TAN'] . ")";
		$result = mssql_query($sql) OR die("fehler beim radio");
//Gibt die Ergebnisse Aus
		$sql = "SELECT Distinct * from ausw where A_ID=$val";
		$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
		$stop = 0;
		while ($row2 = mssql_fetch_assoc($result)) {
				if ($stop == 0)
				{	
				echo "<tr><td>" . $row2['F_Frage'] . "</td>";
				echo "<td>" . $row2['A_Antwort'] . "</td></tr>";
				$stop = 1;
				}
			}
	}
//Wenn der Antworttyp Text, Noten oder Textarea ist, dann wird die gegebene Antwort in GA_Antowort abgespeichert.
	if (($wert == "Textt") OR ($wert == "Noten") OR ($wert == "Areaa")){
		$value = substr($key, 5);
		if (trim(strlen($val)) > 0) {
			$sql = "INSERT INTO gegebeneAntwort
												                (GA_A_ID, GA_T_ID, GA_Antwort)
												            VALUES
												                ( $value,
												                " . $_POST['TAN'] .
			",' $val ')";
				$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");

			$sql = "SELECT Distinct * from ausw where A_ID=$value";
			$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
			$stop = 0;
			//Das Ergebniss wird ausgegeben.
			while ($row2 = mssql_fetch_assoc($result)) {
               if ($stop == 0)
               {				
					echo "<tr><td>" . $row2['F_Frage'] . "</td>";
					echo "<td>" . $val . "</td></tr>";
					$stop = 1;
               }	
				
			}

		}
	}
	
}
//Die Tan wird für ungültig markiert
$sql = "UPDATE TAN
SET T_istgueltig = 'n'
WHERE T_ID =" . $_POST['TAN'];

$result = @ mssql_query($sql) OR die("fehler beim updaten");
?>