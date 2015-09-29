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
	num2= line[5]
	num3= line[6]
	wordline=''
	wordsprev=''
	
	if num1.isdigit():
		count=int(num1)
		
		for p in range(5,len(line)):
			word=line[p]
			wordline=wordsprev+' '+word
			wordsprev=wordline
	
		if wordline==wordlineprev:
			sum=count+countprev
			dict[wordline]=sum
			countprev=sum
		
		else: 
			dict[wordline]=count
			countprev=count
			
		wordlineprev=wordline
		n=n+1
		
	elif num2.isdigit():
		count=int(num2)

		for p in range(6,len(line)):
			word=line[p]
			wordline=wordsprev+' '+word
			wordsprev=wordline
	
		if wordline==wordlineprev:
			sum=count+countprev
			dict[wordline]=sum
			countprev=sum		
			
		else: 
			dict[wordline]=count
			countprev=count		
				
		wordlineprev=wordline
		n=n+1

	else:
		count=int(num3)

		for p in range(7,len(line)):
			word=line[p]
			wordline=wordsprev+' '+word
			wordsprev=wordline
	
		if wordline==wordlineprev:
			sum=count+countprev
			dict[wordline]=sum
			countprev=sum
					
		else: 
			dict[wordline]=count
			countprev=count

		wordlineprev=wordline
		n=n+1

for key in dict:
	output.write(str(dict[key])+key+'\n')

output.close()