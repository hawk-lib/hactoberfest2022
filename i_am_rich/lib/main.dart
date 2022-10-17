import 'package:flutter/material.dart';

//The main function is the starting point for all our flutter apps.
void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
          backgroundColor: Colors.blueGrey,
          appBar: AppBar(
            title: const Text('I am Rich'),
            backgroundColor: Colors.purpleAccent,
          ),
          body: const Center(
            child: Image(
              image: AssetImage('images/tree.jpg'),
          ),
        ),
      ),
    ),
  );
}
