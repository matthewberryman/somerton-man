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
	m=0
	
	for index in line:
		print "index %d is %s" % (m, index)
		count=int(line[5])
		print "count is:%d" % (count)
		
		for p in range(6,len(line)):
			word=line[p]
			print "word %d is:%s" % (p, word)
			wordline=wordsprev+' '+word
			print "wordline is:%s" % (wordline)
			wordsprev=wordline

		if wordline==wordlineprev:
			sum=count+countprev
			print "sum is:%d" % (sum)
			output.write(str(sum)+' '+str(wordline))
				
		elif len(wordline)==len(range(6,len(line))):
			output.write(str(count)+' '+str(wordline))
		
		else:
			print 'Do nothing'
		
		wordlineprev=wordline
		print "wordlineprev is:%s" % (wordlineprev)
		wordline=''
		
		m=m+1
		wordsprev=''
		countprev=count
	output.write('\n')
	n=n+1
