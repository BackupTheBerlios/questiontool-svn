<?php



$verbindung = mssql_connect(MSSQL_HOST, MSSQL_USER, MSSQL_PASS) OR die("Es konnte keine Verbindung zur Datenbank hergestellt werden.");
	;

	while ($verbindung == false) {
		$verbindung = mssql_connect(MSSQL_HOSTs, MSSQL_USER, MSSQL_PASS);
	}
	mssql_select_db(MSSQL_DATABASE) OR die("Die Datenbank konnte nicht ausgewählt werden");
$sql = "SELECT * from diag where F_ID=". $_GET['FID'];
$summe = 0;
		$result = mssql_query($sql) OR die("Es gab Probleme beim SQL-Befehl");
	
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



$plot = new PHPlot(400,300);
$plot->SetImageBorderType('plain');

$plot->SetPlotType('pie');
$plot->SetDataType('text-data-single');
$plot->SetDataValues($data);

# Set enough different colors;
$plot->SetDataColors(array('red', 'green', 'blue', 'yellow', 'cyan',
                        'magenta', 'brown', 'lavender', 'pink',
                        'gray', 'orange'));

# Main plot title:
$plot->SetTitle($_GET['Frage']);


# Build a legend from our data array.
# Each call to SetLegend makes one line as "label: value".
foreach ($data as $row)
  $plot->SetLegend(implode(': ', $row));
//  $plot->SetLegend('Summe');
  $plot->SetShading(0);
$plot->SetLabelScalePosition(0.2);
$text = "Summe: ".  $summe;
$plot->SetXTitle($text);

$plot->DrawGraph();