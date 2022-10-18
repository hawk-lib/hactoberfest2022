import 'package:flutter/material.dart';

showSnackBar({
  required String message,
  required BuildContext context,
}) {
  ScaffoldMessenger.of(context).showSnackBar(
    SnackBar(
      margin: const EdgeInsets.all(8.0),
      behavior: SnackBarBehavior.floating,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
      elevation: 0.0,
      backgroundColor: const Color(0XFF47465b),
      content: Text(
        message,
        style: const TextStyle(
          color: Colors.white,
          letterSpacing: 2.0,
        ),
      ),
    ),
  );
}
