import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:tasks/Framework/task_data.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:tasks/Framework/task.dart';
import 'package:firebase_core/firebase_core.dart';

class AddList extends StatelessWidget {
  late String newTextTitle;
  final _firestore = FirebaseFirestore.instance;
  @override
  Widget build(BuildContext context) {
    return Container(
      color: Color(0xFF757575),
      child: Container(
        decoration: BoxDecoration(
          image: DecorationImage(
              image: AssetImage('images/applicant2.webp'), opacity: 0.15),
          color: Colors.white,
          borderRadius: BorderRadius.only(
              topRight: Radius.circular(20.00),
              topLeft: Radius.circular(20.00)),
        ),
        padding: EdgeInsets.all(60.00),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Text(
              'Add Task or Memo',
              style: TextStyle(
                  fontFamily: 'Lobster',
                  color: Color(0xFF347bbb),
                  fontSize: 30.00,
                  fontWeight: FontWeight.normal),
            ),
            TextField(
                cursorColor: Colors.black,
                style: TextStyle(fontSize: 20),
                textAlign: TextAlign.center,
                autofocus: true,
                onChanged: (newText) {
                  newTextTitle = newText;
                }),
            SizedBox(
              height: 30,
            ),
            MaterialButton(
              elevation: 5.00,
              onPressed: () {
                _firestore.collection('tasks').add({'task': newTextTitle});
                print(Provider.of<TaskData>((context), listen: false).count);
                Provider.of<TaskData>(context, listen: false)
                    .addNewTask(newTextTitle);

                Navigator.pop(context);
              },
              child: Text(
                'Add',
                style: TextStyle(color: Colors.white, fontSize: 25.00),
              ),
              color: Color(0xFF347bbb),
              minWidth: 300,
              height: 50,
            ),
            SizedBox(height: 15),
            Text(
              'Instructions',
              style: TextStyle(fontSize: 20.00),
            ),
            SizedBox(height: 5.00),
            Text('1. Check the box to mark task completed',
                style: TextStyle(fontSize: 15)),
            SizedBox(height: 5.00),
            Text('2. Tap on the data to delete it from the list',
                style: TextStyle(fontSize: 15)),
          ],
        ),
      ),
    );
  }
}
