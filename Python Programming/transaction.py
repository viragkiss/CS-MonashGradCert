from datetime import datetime

class Transaction():

	def __init__(self):
		self.items = {}
		self.total = 0
		self.date = ""

	def __str__(self):
        #products = list(self.items.keys())
        return "Current transaction: date: {}, items: {}, total: {}".format(self.date, self.items, self.total)

    def get_items(self):
    	return self.items

    def add_item(self, item, amount):
    	
    	product = item.get_item_id()
    	
    	if product in self.items:

    		print(self.items[product])
    		name = self.items[product][0]
		    price = self.items[product][1]
		    number = self.items[product][2]
		    number += amount
		    self.items[product] = [name, price, number]

		else:
			name = item.get_name()
			price = item.get_price()
			self.items[product] = [name, price, amount]
		
    	
    	self.calculate_total()

    def remove_item(self, item_id, amount):
    	
    	#product = item.get_item_id()
    	tmpname = item.get_name()
    	#price = item.get_price()
    	
    	if item_id in self.items:
		    
		    print(self.items[item_id])
		    name = self.items[item_id][0]
		    price = self.items[item_id][1]
		    number = self.items[item_id][2]
		    
		    if number > amount:
		    	number -= amount
		    	self.items[item_id] = [name, price, amount]
		    else:
		    	del self.items[item_id]

		else:
		    print("There are no " + tmpname + "s in this transaction.")

        self.calculate_total()


    def calculate_total(self):
    	'''
    	tmp = 0
    	print(list(self.items.values()))
		for v in self.items.values():
    		try:
    			tmp += v
    		except TypeError:
    			print(str(v) + " is not a valid price. Skipping...")
    			continue
    	self.total = tmp
    	print("The total price for this transaction is: "+str(self.total))
    	'''
    	self.total = 0
        for product in self.items:
    		#price = self.items[product][0]
		    #amount = self.items[product][1]
    		self.total += (self.items[product][1] * self.items[product][2])

    	#print("Total: " + str(self.total / 100) )

    def set_date(self):

    	# datetime object containing current date and time
		dt = datetime.now()
		# dd/mm/YY H:M:S, a string
		self.date = dt.strftime("%d/%m/%Y %H:%M:%S")
		print("Transaction date and time: ", self.date)

    def reset(self):
        self.items = {}
        self.total = 0
        self.date = ""