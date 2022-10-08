import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'work.dart';
import 'package:tasks/Framework/task.dart';
import 'package:tasks/Framework/task_data.dart';

class MyWorkList extends StatefulWidget {
  @override
  State<MyWorkList> createState() => _MyWorkListState();
}

class _MyWorkListState extends State<MyWorkList> {
  @override
  Widget build(BuildContext context) {
    return Consumer<TaskData>(builder: (context, taskData, child) {
      return ListView.builder(
          itemBuilder: (context, index) {
            return Work(
                Provider.of<TaskData>(context, listen: false).tasks[index].name,
                Provider.of<TaskData>(context, listen: false)
                    .tasks[index]
                    .isDone, (bool? checkBoxState) {
              Provider.of<TaskData>(context, listen: false).updateTask(
                  Provider.of<TaskData>(context, listen: false).tasks[index]);
            }, () {
              taskData.deleteTask(taskData.tasks[index]);
            });
          },
          itemCount: Provider.of<TaskData>(context, listen: false).count);
    });
  }
}
