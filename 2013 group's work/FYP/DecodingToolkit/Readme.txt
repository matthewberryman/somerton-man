Decoding Toolkit - 2013 Code Cracking Project - Peter Varsos

This document contains a short description of each of the functions
that the toolkit contains.


The toolkit will read in/out from four text documents located 
in the config files folder in the same root document as the jar
file. This can be changed in the text fields at the top of the 
toolkit. Upon changing destination, use the load text button
to load the new texts into the buffers.

The text documents accessed are interchangable, however some of the
functions will expect certain text files when they work. The text
files are:

MSG.txt - The code you are trying to crack for OTP tools
RPT.txt - The file you are looking for the key in
DEC.txt - Where the OTP tools will dump the list of decrpyts
DEC2.txt- Where the OTP tools will dump the shortlist of decrypts

Functions:

Format Texts: Will format MSG and RPT files, removing non letter 
	characters and symbols.
Take First Letters: Replaces RPT text file with the first letters
	of it. 
Frequency Analysis: NYI

Match: Attempts to find exact copies of MSG inside RPT
Partial Match: Attempts to find any substring of MSG inside RPT. Returns
	all partial substrings above 3 letters
Wildcard Match: Attempts to find copies of MSG inside RPT with any
	one letter as a wildcard.
Match Frequency: Searches for all substrings of 2 or above of MSG within
	RPT. Returns them as an array.
	e.g. array[1] = #2 letter matches, array[2] = #3 letter matches..
Line Length Freq: Returns an array with the length (in chars) of the lines
	of RPT.

Get Decrypts: Writes a list of all decrypts to DEC.txt.
	This is every possible decrypt iterating through the RPT document
	and using it as a key for a straight translation OTP decrypt scheme
	for the code in MSG.
Create Shortlist: Takes the list of decrpyts in DEC.txt and outputs a shortlist
	in DEC2.txt. This rates them into 3 catagories depending on their 
	'closeness' to english as defined by a few simple heuristics.
Search Decrypts: Type a word into the box and hit search. This searches
	the DEC.txt file for any string, both exact matches and partial matches.


