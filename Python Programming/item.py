

class Item():

    def __init__(self, item_id, name, price, stock):
        self.item_id = item_id
        self.name = name
        self.price = price
        self.stock = stock
        #self.out_of_stock = out_of_stock

    def __str__(self):       
        return "item id: {}, name: {}, price: {}, items left: {}".format(self.item_id, self.name, self.price, self.stock)

    def get_item_id(self):
        return self.item_id 
    
    def get_name(self):
        return self.name

    def get_price(self):
        return self.price

    def get_stock(self):
        return self.stock

    def set_item_id(self):
        self.item_id = item_id

    def set_name(self, name):
        self.name = name

    def set_price(self, price):
        self.price = price

    def set_stock(self, stock):
        self.stock = stock