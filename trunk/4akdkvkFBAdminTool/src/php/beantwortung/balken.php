<?php
include "config.php";


$verbindung = mssql_connect(MSSQL_HOST, MSSQL_USER, MSSQL_PASS) OR die("Es konnte keine Verbindung zur Datenbank hergestellt werden.");
	;

	while ($verbindung == false) {
		$verbindung = mssql_connect(MSSQL_HOSTs, MSSQL_USER, MSSQL_PASS);
	}
	mssql_select_db(MSSQL_DATABASE) OR die("Die Datenbank konnte nicht ausgewählt werden");
$sql = "SELECT * from diag where F_ID=". $_GET['FID'];
		$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
	$summe = 0;
		while ($row = mssql_fetch_assoc($result)) {
			$data[] = array($row['A_Antwort'], $row['anz']);
			$summe = $summe + $row['anz'];

		}

# PHPlot Example: Pie/text-data-single
require_once 'phplot.php';

# The data labels aren't used directly by PHPlot. They are here for our
# reference, and we copy them to the legend below.
//$data = array(
//  array('Haus', 1),
//  array('Dem Rep Congo', 2),
//  array('Canada', 3),

//);



$plot = new PHPlot(400, 300);
$plot->SetImageBorderType('plain');
$plot->SetPlotType('bars');
$plot->SetDataType('text-data');
$plot->SetDataValues($data);
$plot->SetTitle($_GET['Frage']);


# Turn off X tick labels and ticks because they don't apply here:
$plot->SetXTickLabelPos('none');
$plot->SetXTickPos('none');

# Make sure Y=0 is displayed:
$plot->SetPlotAreaWorld(NULL, 0);
# Y Tick marks are off, but Y Tick Increment also controls the Y grid lines:
$plot->SetYTickIncrement(100);

# Turn on Y data labels:
$plot->SetYDataLabelPos('plotin');

# With Y data labels, we don't need Y ticks or their labels, so turn them off.
$plot->SetYTickLabelPos('none');
$plot->SetYTickPos('none');

# Format the Y Data Labels as numbers with 1 decimal place.
# Note that this automatically calls SetYLabelType('data').
$plot->SetPrecisionY(1);
$plot->SetDataColors(array('red', 'green', 'blue', 'yellow', 'cyan',
                        'magenta', 'brown', 'lavender', 'pink',
                        'gray', 'orange'));
$text = "Summe: ".  $summe;
$plot->SetXTitle($text, plotup);
$plot->DrawGraph();