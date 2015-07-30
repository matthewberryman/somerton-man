#!/usr/bin/env python3

import sys

initialisms = set() # Set for storing unique initialisms

if len(sys.argv) < 2:
  print('Usage: python3 generate_initialisms.py length file1.txt .. filen.txt')
  print('  where length = length of initialisms to be found in code files')
  print('  file1.txt .. filen.txt')

# Read the length of the initialisms to generate from the command line
length = int(sys.argv[1])

# Following command line arguments should be txt files using the code
for codefile in sys.argv[2:]:
  initialism = ''
  # Generate one big string from all the lines:
  for line in open(codefile):
    initialism += line.rstrip()
  # Use a sliding window to find the initialisms...
  for i in range(0,len(initialism)-length+1):
    # ...and add them to the set. Using a set means we only store each unique initialism once only.
    initialisms.add(initialism[i:i+length].upper()) # Conver to upper case for consistency with search_engine.py

# Write the initialisms out to a file, where the filename includes the length of initialisms we've found
file_handle = open(str(length) + 'initialisms.txt','w')
for initialism in initialisms:
  print(initialism,file=file_handle)
