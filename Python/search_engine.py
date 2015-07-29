import csv, sys

initialisms_of_interest = dict()
initialisms = set()

for line in open(sys.argv[1]):
	initialisms.add(line.rstrip())

for initialism in initialisms:
	initialisms_of_interest[initialism] = open('matches_'+initialism+'.txt','w')

reader = csv.reader(sys.stdin, delimiter="\t") # delimiter takes the one character string \t representing tab to specify the field separator

for row in reader:
	ngram = row[0].rstrip().split()
	initialism = ''
	for word in ngram:
		initialism += word[0].upper()
#	print(initialism)
	#for x in initialisms_of_interest:
	#	print(x)
	if initialism in initialisms_of_interest:
		print(' '.join(str(word) for word in ngram),file=initialisms_of_interest[initialism])

for file_handle in initialisms_of_interest.items():
	file_handle[1].close()
