declare -r FILE_NAME="test"

if  find "$FILE_NAME"  
then
	echo "Ok"
else
	echo "Error"
fi
