#!/bin/bash

#В заданной папке копирует файлы в директории, названные по имени владельца 
#каждого файла

directory=$1
if [[ -d $directory ]]
then
  cd $directory
  for file in ./*
  do
    if [[ -f $file ]]
    then
      owner=$(stat -c '%U' $file)
      if [[ -d "./$owner/" ]]
      then
        sudo cp -p $file "./$owner/$file"
      else
        mkdir $owner
        sudo cp -p $file "./$owner/$file"
      fi
    fi
  done
else
  echo "\"$directory\" is not directory"
fi
exit 0
