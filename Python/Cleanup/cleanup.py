#!/usr/bin/env python3
if len(sys.argv) < 2:
	print('Usage: python3 search_engine.py initialisms_file.txt')
	print('  where the initialisms file contains initialisms of interest (all of the same length)')
	exit(1)
reader = csv.reader(sys.argv[1], delimiter=" ") # delimiter takes the one character string \t representing tab to specify the field separator

	# Handle it line by line:
for row in reader:
	for word in row:
		word = word[0:word.find('_')]
