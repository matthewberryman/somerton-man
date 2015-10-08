#!/usr/bin/env python3

import sys, itertools

# 5M_2W
code_segments = [ 'WRGOA', 'BABDM', 'LIAOI', 'WTBIM', 'PANET', 'PMLIA', 'BOAIA', 'QCITT', 'MTSAM', 'STGAB' ]

# 6M_1W_v1
#code_segments = [ 'WRGOA', 'BABDM', 'LIAOI', 'MTBIM', 'PANET', 'PMLIA', 'BOAIA', 'QCITT', 'MTSAM', 'STGAB' ]

# 6M_1W_v2
#code_segments = [ 'MRGOA', 'BABDM', 'LIAOI', 'WTBIM', 'PANET', 'PMLIA', 'BOAIA', 'QCITT', 'MTSAM', 'STGAB' ]

# 7M
#code_segments = [ 'MRGOA', 'BABDM', 'LIAOI', 'MTBIM', 'PANET', 'PMLIA', 'BOAIA', 'QCITT', 'MTSAM', 'STGAB' ]

filenames = list()
for code in code_segments:
    filenames.append(code+'_unique.txt')

top_ngrams = list()

for filename in filenames:
    tuples = list()
    for line in open(filename,'r'):
        row = line.split()
        tuples.append((row[0],' '.join(row[1:])))
    top_ngrams.append([x[1] for x in sorted(tuples)[0:2]])

for x in [' '.join(s) for s in itertools.product(*top_ngrams)]:
    print(x)
    print()
