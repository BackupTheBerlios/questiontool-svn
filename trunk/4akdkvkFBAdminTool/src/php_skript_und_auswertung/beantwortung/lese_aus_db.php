<?php
include "config.php";

//Wenn kein TAN über GET Übergeben worden ist, dann soll ein Formular angezeigt werden, wo der User einen TAN eingeben kann.
if (!isset ($_GET['TAN'])) {       
	echo "<form name=\"Fragebogen\" method=\"GET\" action=\"lese_aus_db.php \">";
	echo "<table>";
	echo "<tr><td><img src=\"logo.GIF\"></td>";
	
	echo "<td><strong><h1>Fragebogen ausfüllen</h1></strong></td></tr>";
	
	echo "<tr><td></td><td>Bitte geben Sie Ihren Tan ein: <input type=\"text\" name=\"TAN\" maxlength=\"16\" size=\"16\" ><td></tr>";
	echo "<tr><td></td><td><input type=\"submit\" value=\"abschicken\"></td></tr>";
	echo "</form>";
	echo "</table>";
	
}

//Es wurde ein TAN übergeben

 else {
	$verbindung = mssql_connect(MSSQL_HOST, MSSQL_USER, MSSQL_PASS) OR die("Es konnte keine Verbindung zur Datenbank hergestellt werden.");
	;

	while ($verbindung == false) {
		$verbindung = mssql_connect(MSSQL_HOSTs, MSSQL_USER, MSSQL_PASS);
	}
	mssql_select_db(MSSQL_DATABASE) OR die("Die Datenbank konnte nicht ausgewählt werden");
?>
<head>
<title>Meinungsforschung</title>
<link rel="stylesheet" type="text/css" href="css.css" />  <!-- Ladet die CSS-Datei -->
</head>
<body style="margin:0;padding:0">
<h1 class="title" align="center">Pre Projekt Meinungsforschung</h1>
<!-- Hier beginnt das Formular -->    
<form name="Fragebogen" method="POST" action="schreibe_in_db.php">

<table  border="0" width="300px" align="center">
<?php

//der Übergebene TAN ist keine Zahl
	if (!(is_numeric($_GET['TAN']))) {
		echo die("ungültige TAN eingegeben");
	}
	$sql = "SELECT * from tan where T_ID = '" . $_GET['TAN']. "'";
	$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
	if (mssql_num_rows($result) == 0) {
		//es wurde eine ungültige ID eingegeben und das Skript wird beendet
		die("Sie sind leider nicht berechtigt den Fragebogen auszuwählen<br /><a href=\"lese_aus_db.php\">Probieren Sie es erneuert</a>");
	} else {
		while ($row = mssql_fetch_assoc($result)) {
			$fbid = $row['FB_ID'];
			if ($row['T_istgueltig'] == 'n') {
				//Falls der TAN schon ausgefüllt ist, wird das Skript beendet
				die("Sie haben den Fragebogen bereits ausgefühlt.<br /> <a href=\"lese_aus_db.php\">Probieren Sie einen anderen TAN</a>");
			}
			
		}
		$sql = "select * from fragebogen where FB_ausfuellen_bis > GETDATE() AND fb_id = $fbid";
	$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
	if (mssql_num_rows($result) == 0) {
		//Wenn das Datum abgelaufen ist
		die("Dieser Fragebogen kann leider nicht mehr ausgefüllt werden");
	}
		
		
		
		
		
//Es wird die View alleFragen benutzt und die Einschränkung ist der Tan, welcher über GET übertragen wird.
		$sql = "SELECT * from alleFragen where T_ID=" . $_GET['TAN'];
		$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
		$stop = 0;
		while ($row = mssql_fetch_assoc($result)) {
			if ($stop == 0) {
				echo "<tr><h1 align=\"center\">" . $row['FB_Titel'] . "</h1></tr>";
				$stop++;
			}
			$counter = 0;
			echo "<tr> <td class=\"question\"> ";
			echo $row['F_Frage'];
			echo " </td></tr>";
			echo "\n";
			$sql = "SELECT * from antwortentyp where A_F_ID = " . $row['F_ID'];
			$result2 = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
			while ($row2 = mssql_fetch_assoc($result2)) {
				switch ($row2['T_Typ']) {
					//Falls der Antworttyp ein Radiobutton ist 
					case "Radio" :
						if ($counter == 0) {   //wird fürs Layout benötigt
							echo "<tr><td class=\"response Radio\">";
						}
						$counter = $counter +1;
// Der Radiobutton bekommt den Namen 'Radio' mit der FragenID. Der Wert ist die AntwortID.
						echo " <tr><td class=\"response\"><input type=\"radio\" name=\"Radio" . $row['F_ID'] . "\" value=" . $row2['A_ID'] . ">" . $row2["A_Antwort"] . "</input>";
						echo "</td></tr> \n";
						//wenn das der letzte Eintrag ist
						if ($counter == (mssql_num_rows($result2))) {
							echo "</tr>";
						}
						break 1;
 // Wenn der Antworttyp eine Checkbox ist.
					case "Checkbox" :
						if ($counter == 0) {
							echo "<tr><td class=\"response\">";
						}
						$counter = $counter +1;
 // Hier wird ein Checkbox Element definiert. Ansprechen lassen sich diese Checkbox-Elemente über ein Array, welches 'Check' mit der FragenID heißt. Der Wert der Checkbox ist die AntwortID 
						echo "<input type=\"checkbox\" name=\"Check" . $row['F_ID'] . "[]\"" . " value=\"" . $row2['A_ID'] . "\">" . $row2['A_Antwort'] . "</input>";
						echo "<br /> \n";
						if ($counter == (mssql_num_rows($result2))) {
							echo "</tr></td>";
						}
						break 1;
//Wenn der Antworttyp ein Text ist
					case "Text" :
						if ($counter == 0) {
							echo "<tr><td class=\"response\">";
						}
						$counter = $counter +1;
// Hier wird ein Text Feld definiert. Ansprechen lässt sich dieses Text Feld über den Namen 'Textt' und der AntwortID
						echo $row2['A_Antwort'] . "<input type=\"text\" name=\"Textt" . $row2['A_ID'] . "\" class=\"Feld\"></input>";
						echo "<br /> \n";
						if ($counter == (mssql_num_rows($result2))) {
							echo "</tr></td>";
						}
						break 1;
//Wenn der Antworttyp eine Textarea ist
					case "Textarea" :
						if ($counter == 0) {
							echo "<tr><td class=\"Bereich\">";
						}
						$counter = $counter +1;
//hier wird ein Textarea Teld definiert für größere Texte. Ansprechen lässt sich dieses Feld über 'Areaa' und der AntwortID						
						echo "<textarea rows=\"5\" cols=\"50\" name=\"Areaa" . $row2['A_ID'] . "\"></textarea>";
						echo "<br /> \n";
						if ($counter == (mssql_num_rows($result2))) {
							echo "</tr></td>";
						}
						break 1;
//Wenn der Anworttyp ein Dropdown Element ist
					case "Dropdown" :
						if ($counter == 0) {
							echo "<tr><td class=\"response\">\n\n";
						}

						if ($counter == 0) {
//hier wird das Dropdown Feld geöffnet							
							echo "<select name=\"Dropd" . $row['F_ID'] . "\"";
							//echo "<br />";
						}
//hier erhaltet das Dropdown Feld werte
//Der Wert ist die AntwortID.						
						echo "<option value=\"" . $row2['A_ID'] . "\">" . $row2['A_Antwort'] . "</option>";
						$counter = $counter +1;
						if ($counter == (mssql_num_rows($result2))) {
							echo "</select>";
							echo "</td></tr>";
							echo "<br />";
						}

						break 1;
//Wenn der Antworttyp ein Notensystem ist.

					case "Noten" :
						if ($counter == 0) {
							echo "<tr>";
//Für jede Note gibt es eine eigene Zeile. Angesprochen wird das Feld mit 'Noten' und der AntwortID. 							
							echo "<td>1 <input type=\"radio\" name=\"Noten" . $row2['A_ID'] . "\" value=\"1\"" . ">" . "</input> \n";
							echo "2 <input type=\"radio\" name=\"Noten" . $row2['A_ID'] . "\" value=\"2\"" . ">" . "</input>  \n";
							echo "3 <input type=\"radio\" name=\"Noten" . $row2['A_ID'] . "\" value=\"3\"" . ">" . "</input>  \n";
							echo "4<input type=\"radio\" name=\"Noten" . $row2['A_ID'] . "\" value=\"4\"" . ">" . "</input>  \n";
							echo "5 <input type=\"radio\" name=\"Noten" . $row2['A_ID'] . "\" value=\"5\"" . ">" . "</input></td> <br /> \n";
							echo "</tr>";
						}
						break 1;
			}
		}
	}

}
echo "</table>";

//Die TAN wird versteckt mitgesendet
echo "<input type=\"hidden\" name=\"TAN\" value=\"" . $_GET['TAN'] . "\"></input>";
echo "<div align=\"center\">";
echo "<input type=\"submit\" value=\"abschicken\">"; //abschickbotton
echo "</div>";

}
?>