#!/usr/bin/env python3

import sys, csv

if len(sys.argv) < 2:
	print('Usage: python3 cleanup.py file_to_be_cleaned.txt')
	print('  where the file to be cleaned contains ngrams.')
	print('  This code removes the word type from ngrams.')
	exit(1)
reader = csv.reader(open(sys.argv[1],'r'), delimiter=" ") # delimiter takes the one character string \t representing tab to specify the field separator

	# Handle it line by line:
for row in reader:
	for word in row:
		if '_' in word:
			word = word[0:word.find('_')]
		print(word, end=' ')
	print()
