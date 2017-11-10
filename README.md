# TP-Apps-Informaticas

# Instructions

These instructions shows you how to set up an Angular 4 Project. If you are cloning this repository into your computer, then run the following commands:

   cd BookingRecommendationSystem
   npm install

Requirements: 
	nodejs


Important: you need to use at least 1GB of disk memory.


1) Install the latest version of node

	wget -qO- https://deb.nodesource.com/setup_8.x | sudo bash -
	sudo apt-get install -y nodejs

2) Install Angular CLI
	
	sudo npm install -g @angular/cli

   ( sudo may not be required )

3) Set up a new project

   To start an Angular Project , run:

   ng new <project_name> 

   Installs the required packages 

   (Make sure to have enough space on your disk!)

4) Launch Angular Server

   cd <project_name>
   ng serve --open

   It binds to host port 4200 by default

Additional Notes

To unbind a host port, run 
  fuser -k <port>/tcp