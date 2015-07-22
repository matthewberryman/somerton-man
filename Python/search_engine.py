import csv
with open('5-gram_aa_sample.txt', 'r') as file:
	reader = csv.reader(file, delimiter="\t") # delimiter takes the one character string \t representing tab to specify the field separator
	d = list(reader) # creates a list in variable d containing the elements in reader

"""item1 = d[0] # moves up and down
element1 = item1[2] # moves left and right
print element1

print type(element1)"""



n=0
gramprev = 'string'
dictionary = dict()
countintprev = 0

for element in d:
	item = d[n]
	#print "item %d is %s" % (n, item)
	gram = item[0]
	#print "gram %d is %s" % (n, gram)
	
	if gram == gramprev:
		countint = countintprev + int(item[2])
		#print "count %d is %d" % (n, countint)
		
		
	else:
		count = item[2]
		countint = int(count)
		#print "count %d is %d" % (n, countint)
	
	countintprev = countint
	gramprev = gram

	dictionary[gram] = countint
	#print "dictionary item %d is: " % (n)# + dictionary[n]
	
	n=n+1
	
print dictionary['AA and BB are the']
	


item1 = d[0] # moves up and down
gram = item1[0] # moves left and right
print gram

input = gram
initialism = ""
for letter in input.upper().split():
    initialism += letter[0]
print initialism

#initdictionary[initialism]=gram
"""#Reference:
input = "Self contained underwater breathing apparatus"
output = ""
for i in input.upper().split():
    output += i[0]
print output"""
