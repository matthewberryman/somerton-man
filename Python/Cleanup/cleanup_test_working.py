import csv
with open('output_5_test.txt', 'r') as file:
	reader = csv.reader(file, delimiter=" ") # delimiter takes the one character string \t representing tab to specify the field separator
	d = list(reader) # creates a list in variable d containing the elements in reader
output = open('output_5_test_clean.txt', 'w')
	
m=0
n=0
o=0
replace=0

for element in d:
	line = d[n]
	print "line %d is %s" % (n, line)
	m=0
	for word in line:
		print "word %d is %s" % (m, word)
		replace=0
		for letter in word:
			print "letter %d is %s" % (o, letter)
			if letter=='_':
				head, middle, tail = word.partition('_')
				print head
				replacement=str.replace(word, word, head)
				line.remove(word)
				line.insert(m,replacement)
				replace=1	
		if replace==1:
			output.write(str(replacement)+' ')
		else:
			output.write(str(word)+' ')
		m=m+1
	output.write('\n')
	n=n+1
	
print d

'''
outputstring = " ".join(str(x) for x in d)
output.write(outputstring)
output.close()
'''
"""
cleanline = " ".join(str(x) for x in line)
output.writelines("" ".join(%s)\n" %cleanline for cleanline in d)
output.close()
"""
#outstring = str('\n'.join(d))
#output.write(outstring)
#output.close()

"""	
input_file = open('output_5_test.txt', 'r')

a=0
for a in input_file
read = input_file.readline(a)
head, sep, tail = read.partition('_')


text = 'some string... this part will be removed.'
head, sep, tail = input_file.partition('_')

output_file = open('
output_file.write(head+tail)



original = "EXAMPLE"
removed = original.replace("M", "")
"""

"""
text = "     39 Abbot_NOUN of_ADP Inchaffray_NOUN walked_VERB through_ADP"
print text.rstrip('_')

size/2 to 0
to size/2 to size
bubble search?
"""

"""
import re
s = "     39 Abbot_NOUN of_ADP Inchaffray_NOUN walked_VERB through_ADP"
t = re.sub('_.+ ', '', s)


print s['_':]
"""


