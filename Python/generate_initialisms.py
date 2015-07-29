#!/usr/bin/env python

import sys

initialisms = set()

length = int(sys.argv[1])

for codefile in sys.argv[2:]:
  initialism = ''
  for line in open(codefile):
    initialism += line.rstrip()
  for i in range(0,len(initialism)-length+1):
    initialisms.add(initialism[i:i+length])


file_handle = open(str(length) + 'initialisms.txt','w')
for initialism in initialisms:
  print(initialism,file=file_handle)
