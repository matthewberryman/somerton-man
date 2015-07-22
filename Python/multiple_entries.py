control = {"Andrew" : "Cambridge", "Barabara" : "Bloomsbury", "Andrew": "Corsica"}
print control

class person(object):
	def __init__(self,name):
		self.name = name

control["Andrew"] = "Test"
print control

control[person("Andrew")] = "Test2"
print control

# Website: http://www.wellho.net/mouth/3934_Multiple-identical-keys-in-a-Python-dict-yes-you-can-.html