<?php


$server="127.0.0.1";
$username ="root";
$password="";
$databaseName="employeeDatabase"; 

$connection = mysqli_connect($server, $username, $password, $databaseName);


if($connection==true)
{

	//echo "You are connected to database, and you can perform any operation now..."; 
	$qresult=mysqli_query($connection, "select * from employeeInfo");
	$counter=1;
	
	$data = array();
	while($record = mysqli_fetch_assoc($qresult))
	{
	
		$Name=$record['Name'];
		$EmployeeID=$record['eID'];
		$Age=$record['Age'];
		$date=$record['date'];
		
		//echo "\n Record No. $counter \n Name: $name \n Designation: $des \n Salary: $sal\n\n"; 
		
	
		$data[] = $record;
	
		
	
		$counter = $counter +1; 
	}// end of while loop 
	
	echo json_encode($data);

}
else
{
echo "Unable to connect to database, perhaps something goes wrong..";
}



?>