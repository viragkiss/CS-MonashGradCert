
class VendingMachine():

	def __init__(self):
		
		self.stock = []
		self.transactions = []
		self.change = 0
		self.operational = True

	'''
	def __str__(self):
        print_stock = 

        return "stock: {}, total: {}, date: {}".format(self.items, self.total, self.date)
    '''

    def setup_machine(self, products):
    	
    	# items = { coffee : 450, tea : 350, coke : 500, juice : 550 }

        # is the machine operational? y / n
    	operational = input("Is the machine operational? y / n")
    	if operational == "n":
    		self.operational = False
    		return "You set the mahcine as non-operational. Display message will be adjusted."

    	# add products
    	count = 1
        for p in products:
            name = p
            price = products[p]
            quantity = int(input("How many" + name + "s would you like to add? "))  # have to give valid quantity
            product = Item(count, name, price, quantity)
            self.stock.append(product)   
            count++

    	# add change
    	self.change = int(input("Enter the amount of change you want to put in the machine, in whole dollars: "))

    	return "Thank you, your machine is set up and ready to use!"

    
    def display_products(self):

    	for product in self.stock:

    		if product.get_stock() < 1:
    			print(product.get_item_id() + " " + product.get_name() + " Out of Stock")
    		else:
    			print(product)
    		

    def display_transaction_history(self):

    	for transaction in self.transactions:
    		print(transaction)

    	print("Successfully displayed transaction history.")

    
    def add_items(self, transaction):

    	self.display_products()
    	while True:
	    	choice = int(input("Select product to add: "))
	    	if choice < len(self.stock):
	    		
	    		product = self.stock[choice]

	    		if product.get_stock() < 1:
	    			print("Out of stock. Please choose another product.")
	    		else:
		    		amount = int(input("How many " + product.get_name() + "s would you like to add?"))

                    if product.get_stock() < amount:
                        print("Not enough items available.")
                    else:
		    		    transaction.add_item(product, amount)
		    		    transaction.calculate_total()
		    		    print(transaction)
		    else:
		    	print("Invalid input. Please choose from the available items.")

		    keep_going = input("Would you like to add more items? y / n: ")
		    if keep_going == "n":
	    		break

    
    def remove_items(self, transaction):

        items = transaction.items

        while True:

            item_id = int(input("To choose the product you wish to edit, enter its number: ")) # supposed to enter product id
            
            if item_id in items:
                print("Item to delete: " + items[item_id])
                amount = int(input("How many would you like to delete?"))
                transaction.remove_item(item_id, amount)   
            else:
                print("Invalid product number.")

            keep_going = input("Would you like to delete more items? y / n: ")
            if keep_going == "n":
                break

	
    def edit_transaction(self, transaction):

		print(transaction)

		action = input("What would you like to do?\n1 Add more items\n2 Delete items")

        if action == "1":
            self.add_items(transaction)

        elif action == "2":
            self.remove_items(transaction)

        else:
            print("Invalid choice.")

	def cancel_transaction(self, transaction):

        print(transaction)

        action = input("Are you sure you want to cancel this transaction? y /n")

        if action == "y":
            transaction.reset()
            print(transaction)
            print("Transaction cancelled.")
        elif action == "n":
            print("Transaction restrored.")
        else:
            print("Invalid input.")

    def reset_machine(self, products):
        self.operational = True
        self.change = 50
        
        # add products
        count = 1
        for p in products:
            name = p
            price = products[p]
            quantity = 10
            product = Item(count, name, price, quantity)
            self.stock.append(product)
            count += 1
        
        return "Thank you, your machine is set to default mode!"