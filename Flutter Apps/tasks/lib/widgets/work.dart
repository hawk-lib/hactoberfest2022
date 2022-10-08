import 'package:flutter/material.dart';

class Work extends StatelessWidget {
  final bool isChecked;
  final String work;
  var checkBoxCallBack;
  var onTap;
  Work(this.work, this.isChecked, this.checkBoxCallBack, this.onTap);
  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: Icon(
        Icons.dashboard_rounded,
        color: Color(0xFF347bbb),
      ),
      onTap: onTap,
      title: Text(
        work,
        style: TextStyle(color: isChecked ? Colors.red : null, fontSize: 20.00),
      ),
      trailing: Checkbox(
          activeColor: Color(0xFF347bbb),
          value: isChecked,
          onChanged: checkBoxCallBack),
    );
  }
}
