
import pygame


class Slider():
	def __init__(self, 
			x = 0, y = 0, width = 100, height = 20,
			body_color = (204,204,204), fill_color = (135,206,235),

			handle_width = 10, handle_height = None,
			handle_color = (33,150,243) , handle_hover_color = None,

			body_radius = 0, handle_radius = None,
			id=None, percent=0):
		
		# Important values
		self.type = "slider"
		self.id = id
		self.send_back_item = False  # Logic is run in the main app when this is true (is only true when percent has changed)

		# Percent values
		self.percent = percent     # Current percent
		self.old_percent = percent # Old percent, to keep it from constanlty updating, unless there is a change

		# Location and size of bidy
		self.x = x
		self.y = y
		self.width = width
		self.height= height

		# Loaction and size of handle
		self.handle_x = x
		self.handle_y = y
		self.handle_width = handle_width
		self.handle_height = handle_height
		if handle_height == None:
			self.handle_height = height


		# Color and shape of body
		self.body_color = body_color
		self.fill_color = fill_color
		self.body_radius = body_radius


		# Color and shape of handle
		self.handle_color = handle_color
		self.handle_hover_color = handle_hover_color
		self.handle_radius = handle_radius
		if handle_radius == None:
			self.handle_radius = self.body_radius

		# Value to stop the handle's x value to be equal to the mouse value.
		# If it dosent exist, then the handle would "jump" forward to the mouse's x value when clicked in the middle
		self.mouse_diff = 0

		# Other
		self.hover = False      # If we are hovering the handle
		self.clicked = False    # check if handle has been clicked
		self.change = False     # HAs the handle been moved?
		self.first_time_load = True # Runs some spesific logic upon first run(that cant be done while initializing)




	def run(self, screen, mouse, dt, key_event):

		# If mouse is not clicked
		if mouse[1][0] == False:
			self.clicked = False

		# Should we send back information to the main loop?
		self.send_back_item = False

		# If main body has been moved since creation we use this to center handle.
		# We also use this to center based on start percent different than 0
		if self.first_time_load == True:
			self.center()
			self.first_time_load = False


		# See if mouse is within the handle.
		if self.handle_hover_check(mouse) == True or self.clicked == True:
			self.hover = True
		else:
			self.hover = False

		# See if we are within the handle AND click down on it
		if self.hover == True and mouse[1][0] == True and self.clicked == False:
			self.clicked = True

			# Value to stop the handle's x value to be equal to the mouse value.
			# If it dosent exist, then the handle would "jump" forward to the mouse's x value when clicked in the middle
			self.mouse_diff = self.handle_x - mouse[0][0]
		
		
		# If we are hovering AND have clicked, then we move the handle's x value to match the mouse and run change logic
		if self.hover == True and self.clicked == True:
			self.change = True
		
		# So the handle will jump to the mouse when clicking the bar somewhere else.
		if self.bar_hover_check(mouse) == True:
			if mouse[1][0] == True:
				self.hover = True
				self.clicked = True
				self.change = True
				self.mouse_diff = -self.handle_width/2


		# When we are hover AND have clicked the handle, this happens:
		if self.change == True:
			self.move_handle(mouse)       # Moves the handle
			self.calculate_percent(mouse) # Makes new percent values
			self.change = False           # So this is only run while hover and clicked are true

		# Draw everything(bar, fill, handle)
		self.draw(screen)

		return {"hover":self.hover, "triggered":self.send_back_item, "id":self.id, "content":self.percent, "type":self.type}
	

	# Drawing the slider
	def draw(self, screen):
		width_fill = (self.width * (self.percent/100))
		pygame.draw.rect(screen, self.body_color, (self.x, self.y, self.width, self.height), border_radius=self.body_radius)  
		pygame.draw.rect(screen, self.fill_color, (self.x, self.y, width_fill, self.height), border_radius=self.body_radius) 
		pygame.draw.rect(screen, self.handle_color, 
				   		(self.handle_x, self.handle_y, self.handle_width, self.handle_height), border_radius=self.handle_radius)  


	# Moving the handle
	def move_handle(self, mouse):
		self.handle_x = mouse[0][0] + self.mouse_diff
		if self.handle_x < self.x:
			self.handle_x = self.x
		if self.handle_x + self.handle_width > self.x+self.width:
			self.handle_x = self.x+self.width-self.handle_width


	# Checks if the mouse hovers the handle
	def handle_hover_check(self, mouse):
		if mouse[0][1] > self.handle_y and mouse[0][1] < self.handle_y + self.handle_height:
			if mouse[0][0] > self.handle_x and mouse[0][0] < self.handle_x + self.handle_width:
				return True
			else:
				return False

	# Checks it mouse hovers the bar
	def bar_hover_check(self, mouse):
		if self.handle_hover_check(mouse) == False:
			if mouse[0][1] > self.y and mouse[0][1] < self.y + self.height:
				if mouse[0][0] > self.x and mouse[0][0] < self.x + self.width:
					return True



	# Centers handle upon first load
	def center(self):
		
		# Center vertically:
		self.handle_y = self.y + ((self.height - self.handle_height) / 2)

		whole = self.width-self.handle_width

		self.handle_x = ((self.percent / 100) * whole) + self.x
		
		# Find new x position based on start percent:
		if self.percent < 0:
			self.handle_x = self.x
		if self.percent > 100:
			self.handle_x = self.x + self.width - self.handle_width


	# Calculate percent based on where the handle is
	def calculate_percent(self, mouse):
		part = self.handle_x - self.x
		whole = self.width-self.handle_width
		self.percent = round((part / whole * 100), 2)
		if self.percent != self.old_percent:
			self.send_back_item = True
			self.old_percent = self.percent
		

