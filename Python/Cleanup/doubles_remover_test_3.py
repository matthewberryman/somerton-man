import csv
with open('doubles_test.txt', 'r') as file:
	reader = csv.reader(file, delimiter=" ") # delimiter takes the one character string \t representing tab to specify the field separator
	d = list(reader) # creates a list in variable d containing the elements in reader
output = open('doubles_test_doubles_removed.txt', 'w')

n=0
wordlineprev = ''
wordsprev = ''
wordline = ''
countprev = 0
dict = {}

for element in d:
	line = d[n]
	count=int(line[5])
	
	wordline=''
	wordsprev=''
		
	for p in range(6,len(line)):
		word=line[p]
		wordline=wordsprev+' '+word
		wordsprev=wordline
	
	if wordline==wordlineprev:
		sum=count+countprev
		dict[wordline]=sum
		
	else: 
		dict[wordline]=count

	wordlineprev=wordline
	countprev=count
	n=n+1

for key in dict:
	output.write(str(dict[key])+key+'\n')

output.close()