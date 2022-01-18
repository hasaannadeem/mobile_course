
<?php



$connection = mysqli_connect("127.0.0.1", "root", "", "employeeDatabase");


$eName=$_POST['column1'];
$eID=$_POST['column2'];
$Age=$_POST['column3'];
$Date=$_POST['column4'];


if($connection==true)
{

	//echo "You are connected to database, and you can perform any operation now..."; 
	
	$qresult=mysqli_query($connection, "insert into employeeInfo values('$Name', '$FatherName', '$Class', '$PhoneNo');");
	if($qresult)
		echo "</br> Record is inserted.. " ;
	else
		echo "unable to insert record"; 

}
else
{
echo "Unable to connect to database, perhaps something goes wrong..";
}



?>