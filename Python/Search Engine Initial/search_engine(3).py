import csv
with open('5-gram_aa_sample.txt', 'r') as file:
	reader = csv.reader(file, delimiter="\t") # delimiter takes the one character string \t representing tab to specify the field separator
	d = list(reader) # creates a list in variable d containing the elements in reader

"""item1 = d[0] # moves up and down
element1 = item1[2] # moves left and right
print element1

print type(element1)"""

while True:
	combo = raw_input('Enter a letter combination up to 5 letters: ')
	comboup = combo.upper()
	#print comboup
	#print type(comboup)

	if len(comboup) > 5:
		print 'Letter combination is greater than 5'
	#elif any(char.isdigit() for char in comboup):
		#print 'Letter combination contains numbers'
	else:
		break

#combolength = len(comboup)
#if combolenght == 1:

n=0
gramprev = 'string'
dictionary = dict()
initdictionary = dict()
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
	
	input = gram
	initialism = ""
	for letter in input.upper().split():
    		initialism += letter[0]
	#initdictionary[initialism].append() = gram
	#######initdictionary[initialism].append(gram)
	#initdictionary.append(initialism,gram)
	initdictionary[initialism] = gram
	#print "dictionary item %d is: " % (n)# + dictionary[n]
	#class initialism(gram):
	#	def __init__(self,initialism):
    #			self.initialism = initialism
	n=n+1
	
#print dictionary['AA and BB are the']
#print initdictionary['AAAFH']

#data['Names']['first'].append(value)

if comboup in initdictionary:
	fullgram = initdictionary[comboup]
	print fullgram
	totalcount = dictionary[fullgram]
	print totalcount
	total = sum(dictionary.itervalues())
	print total
	statistic = float(totalcount) / float(total)
	print statistic
else:
	print "There are no results for that letter combination"
	