<?php
include "config.php";
$_GET['FID'] = 16;

$verbindung = mssql_connect(MSSQL_HOST, MSSQL_USER, MSSQL_PASS) OR die("Es konnte keine Verbindung zur Datenbank hergestellt werden.");
	;
$stop=0;
	while ($verbindung == false) {
		$verbindung = mssql_connect(MSSQL_HOSTs, MSSQL_USER, MSSQL_PASS);
	}
	mssql_select_db(MSSQL_DATABASE) OR die("Die Datenbank konnte nicht ausgewählt werden");
$sql = "SELECT * from radio";
		$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
	
		while ($row = mssql_fetch_assoc($result)) {
			if ($stop == 0)
			{
				echo "<h1 align=\"center\">".$row['FB_Beschreibung']."</h1>";
				$stop = 1;
			}
echo "<img src=\"diag.php?FID=".$row['F_ID']. "&Frage=". $row['F_Frage'].   "\" /><br />";
		}

$sql = "SELECT * from checkbox";
		$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
	
		while ($row = mssql_fetch_assoc($result)) {
echo "<img src=\"balken.php?FID=".$row['F_ID']. "&Frage=". $row['F_Frage'].   "\" /><br />";
		
		}
?>
