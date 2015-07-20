#!/usr/bin/env bash

# Script for downloading the 2012 English n-gram data set from http://storage.googleapis.com/books/ngrams/books/datasetsv2.html

# 1-grams:
for n in {0..9}
do
  wget "http://storage.googleapis.com/books/ngrams/books/googlebooks-eng-all-1gram-20120701-${n}.gz"
done
for x in {a..z}
do
  wget "http://storage.googleapis.com/books/ngrams/books/googlebooks-eng-all-1gram-20120701-${x}.gz"
done

# 2-grams .. 5-grams:
for i in {2..5}
do
  for n in {0..9}
  do
    wget "http://storage.googleapis.com/books/ngrams/books/googlebooks-eng-all-${i}gram-20120701-${n}.gz"
  done
  for x in {a..z}
  do
    wget "http://storage.googleapis.com/books/ngrams/books/googlebooks-eng-all-${i}gram-20120701-${x}_.gz"
    for y in {a..z}
    do
      wget "http://storage.googleapis.com/books/ngrams/books/googlebooks-eng-all-${i}gram-20120701-${x}${y}.gz"
    done
  done
done
