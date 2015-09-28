import csv
with open('doubles_test.txt', 'r') as file:
	reader = csv.reader(file, delimiter=" ") # delimiter takes the one character string \t representing tab to specify the field separator
	d = list(reader) # creates a list in variable d containing the elements in reader
output = open('doubles_test_doubles_removed.txt', 'w')


m=0
n=0
o=0
replace=0
wordlineprev = ''
wordsprev = ''
wordline = ''
countprev = 0

for element in d:
	line = d[n]
	#print "line %d is %s" % (n, line)
	count=int(line[5])

	for p in range(6,len(line)):
		word=line[p]
		print "word %d is:%s" % (p, word)
		wordline=wordsprev+' '+word
		print "wordline is:%s" % (wordline)
		wordsprev=wordline
		
	wordlinefinal=wordline
	
	if wordlinefinal==wordlineprev:
		sum=count+countprev
		print "sum is:%d" % (sum)
		output.write(str(sum)+' '+str(wordlinefinal))

	else:
		output.write(str(count)+' '+str(wordlinefinal))
		
	wordlineprev=wordlinefinal
	
	print "wordlineprev is:%s" % (wordlineprev)
	
	wordline=''
	wordsprev=''
	countprev=count
	output.write('\n')
	n=n+1
