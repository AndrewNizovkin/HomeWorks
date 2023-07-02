#!/bin/bash
#Удаляет из дирректории, переданной параметром файлы 
#с расширениями .bak, .tmp, .backup

directory=$1
if [ -d $directory ]
then
  for file in $directory*
  do
     if [ -e $file ]
     then
       if [[ ${file: -4} == ".bak" || ${file: -4} == ".tmp" || ${file: -7} == ".backup" ]]
       then
         rm $file
       fi
     fi
 done
else
  echo "\"$directory\" is not directory"
fi
exit 0
