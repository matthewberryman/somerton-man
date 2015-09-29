import csv
with open('doubles_test.txt', 'r') as file:
	reader = csv.reader(file, delimiter=" ") # delimiter takes the one character string \t representing tab to specify the field separator
	d = list(reader) # creates a list in variable d containing the elements in reader
output = open('doubles_test_output.txt', 'w')

n=0
wordlineprev = ''
wordsprev = ''
wordline = ''
countprev = 0
dict = {}

for element in d:
	line = d[n]
	num1= line[4]
	wordline=''
	wordsprev=''
	
	if num1.isdigit():
		count=int(line[4])
		
		for p in range(5,len(line)):
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
		
	else:
		count=int(line[5])

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