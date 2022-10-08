import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'screens/TaskScreen.dart';
import 'package:tasks/Framework/task_data.dart';
import 'package:tasks/screens/homeScreen.dart';
import 'package:firebase_core/firebase_core.dart';

void main() async {
  runApp(MyApp());
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) => TaskData(),
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        home: HomeScreen(),
      ),
    );
  }
}
