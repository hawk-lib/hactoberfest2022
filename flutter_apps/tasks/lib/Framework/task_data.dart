import 'dart:collection';

import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:tasks/screens/TaskScreen.dart';
import 'task.dart';

class TaskData extends ChangeNotifier {
  List<Task> tasks = [];
  int get count {
    return tasks.length;
  }

  void addNewTask(String newText) {
    tasks.add(Task(newText, false));
    notifyListeners();
  }

  void updateTask(Task task) {
    task.toggle();
    notifyListeners();
  }

  void deleteTask(Task task) {
    tasks.remove(task);
    notifyListeners();
  }
}
