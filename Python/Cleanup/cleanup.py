import csv
with open('output_4.txt', 'r') as file:
	reader = csv.reader(file, delimiter=" ") # delimiter takes the one character string \t representing tab to specify the field separator
	d = list(reader) # creates a list in variable d containing the elements in reader
output = open('output_4_clean.txt', 'w')
	
n=0
replace=0

for element in d:
	line = d[n]
	m=0
	for word in line:
		replace=0
		for letter in word:
			if letter=='_':
				head, middle, tail = word.partition('_')
				replace=1	
		if replace==1:
			output.write(str(head)+' ')
		else:
			output.write(str(word)+' ')
	output.write('\n')
	n=n+1
output.close()