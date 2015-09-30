import csv
with open('output_5_clean.txt', 'r') as file: # specifies file input
	reader = csv.reader(file, delimiter=" ") # delimiter takes the one character string " " representing a space to specify the field separator
	d = list(reader) # creates a list in variable d containing the elements in reader
output = open('output_5_count.txt', 'w') # specifies file output 

n=0
wordlineprev = ''
wordsprev = ''
wordline = ''
countprev = 0
dict = {}

for element in d: # iterates through each line in the list
	line = d[n]
	num1= line[4]
	num2= line[5]
	num3= line[6]
	wordline=''
	wordsprev=''
	
	if num1.isdigit(): # checks position of count for number of years each entry occurs
		count=int(num1)
		
		for p in range(5,len(line)): # iterates onwards after number position to capture the remaining text as a string
			word=line[p]
			wordline=wordsprev+' '+word
			wordsprev=wordline
		
		if wordline in dict: # adds count to existing count if dictionary key already exists
			dict[wordline]=(dict[wordline]+count)
			
		else: # adds new key to dictionary and assigns its initial count value
			dict[wordline]=count
			
		n=n+1
		
	elif num2.isdigit(): # checks position of count for number of years each entry occurs
		count=int(num2)

		for p in range(6,len(line)): # iterates onwards after number position to capture the remaining text as a string
			word=line[p]
			wordline=wordsprev+' '+word
			wordsprev=wordline

		if wordline in dict: # adds count to existing count if dictionary key already exists
			dict[wordline]=(dict[wordline]+count)
			
		else: # adds new key to dictionary and assigns its initial count value
			dict[wordline]=count
			
		n=n+1

	else:  # checks position of count for number of years each entry occurs
		count=int(num3)

		for p in range(7,len(line)): # iterates onwards after number position to capture the remaining text as a string
			word=line[p]
			wordline=wordsprev+' '+word
			wordsprev=wordline
	
		if wordline in dict: # adds count to existing count if dictionary key already exists
			dict[wordline]=(dict[wordline]+count)
			
		else: # adds new key to dictionary and assigns its initial count value
			dict[wordline]=count
			
		n=n+1

for key, value in sorted(dict.iteritems(), key=lambda (v,k): (k,v), reverse=True): # iterates through dictionary and outputs to text file in order from largest count value to smallest
	output.write(str(dict[key])+key+'\n')

output.close()