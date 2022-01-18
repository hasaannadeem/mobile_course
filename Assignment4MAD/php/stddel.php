<?php


$server="127.0.0.1";
$username ="root";
$password="";
$databaseName="stdrecord"; 

$connection = mysqli_connect($server, $username, $password, $databaseName);



$eID=$_POST['column2'];

if($connection==true)
{

	//echo "You are connected to database, and you can perform any operation now..."; 
	
	$qresult=mysqli_query($connection, "Delete FROM employeeInfo WHERE eID='$eid;");
	if($qresult)
		echo "</br>Record Deleted.. $Name  " ;
	else
		echo "Error : Not deleted"; 

}
else
{
echo "Unable to connect to database, perhaps something goes wrong..";
}



?>