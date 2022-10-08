import 'package:flutter/material.dart';
import 'package:tasks/Framework/task_data.dart';
import 'package:tasks/widgets/myWorkList.dart';
import 'new_tasks.dart';
import 'package:tasks/Framework/task.dart';
import 'package:provider/provider.dart';

class TaskScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF347bbb),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Color(0xFF347bbb),
        child: Icon(Icons.add_card_outlined),
        onPressed: () {
          showModalBottomSheet(
            context: context,
            builder: (context) => AddList(),
          );
        },
        elevation: 5.00,
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Container(
            padding: EdgeInsets.only(top: 60, right: 30, left: 30, bottom: 30),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                CircleAvatar(
                    backgroundColor: Colors.white,
                    child: Icon(
                      Icons.task,
                      size: 30,
                      color: Color(0xFF347bbb),
                    ),
                    radius: 30),
                SizedBox(
                  height: 10,
                ),
                Text(
                  'Schedula',
                  style: TextStyle(
                      fontFamily: 'Pacifico',
                      color: Colors.white,
                      fontSize: 50.00,
                      fontWeight: FontWeight.normal),
                ),
                Text(
                  '${context.watch<TaskData>().count} Tasks Remaining',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 18.00,
                  ),
                ),
              ],
            ),
          ),
          Expanded(
            child: Container(
              decoration: BoxDecoration(
                color: Colors.white,
                image: DecorationImage(
                  opacity: 0.2,
                  image: AssetImage('images/hey.jpg'),
                ),
                borderRadius: BorderRadius.only(
                    topLeft: Radius.circular(20.00),
                    topRight: Radius.circular(20.00)),
              ),
              child: MyWorkList(),
            ),
          )
        ],
      ),
    );
  }
}
