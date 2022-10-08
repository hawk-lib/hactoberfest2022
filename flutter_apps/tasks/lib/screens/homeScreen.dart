import 'package:flutter/material.dart';
import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:tasks/screens/TaskScreen.dart';

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF347bbb),
      body: SafeArea(
        child: Container(
          padding: EdgeInsets.symmetric(horizontal: 25.00, vertical: 160),
          child: Center(
            child: Column(
              children: <Widget>[
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    CircleAvatar(
                        radius: 30.00,
                        backgroundColor: Colors.white,
                        child: Icon(
                          Icons.task,
                          color: Color(0xFF347bbb),
                          size: 30,
                        )),
                    SizedBox(width: 20.00),
                    Text(
                      'Schedula',
                      style: TextStyle(
                          fontFamily: 'Pacifico',
                          fontSize: 45.00,
                          color: Colors.white),
                    ),
                  ],
                ),
                Text(
                  '   Your Personal Day to Day Manager',
                  style: TextStyle(color: Colors.white, fontSize: 20.00),
                ),
                SizedBox(
                  height: 30,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    DefaultTextStyle(
                      style: TextStyle(fontSize: 30.00, fontFamily: 'Lobster'),
                      child: AnimatedTextKit(
                        animatedTexts: [
                          ScaleAnimatedText('Manage Tasks'),
                          ScaleAnimatedText('Write Notes'),
                          ScaleAnimatedText('Create Memos'),
                        ],
                        totalRepeatCount: 1,
                        pause: Duration(milliseconds: 1000),
                        onFinished: () {
                          Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => TaskScreen()));
                        },
                      ),
                    ),
                  ],
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
