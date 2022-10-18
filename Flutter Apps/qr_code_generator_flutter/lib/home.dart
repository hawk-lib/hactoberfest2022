import 'package:flutter/material.dart';
import 'package:qr_code_generator_flutter/utils.dart';
import 'package:qr_flutter/qr_flutter.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final TextEditingController _controller = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => FocusScope.of(context).unfocus(),
      child: Scaffold(
        appBar: AppBar(
          title: Text('qr code'.toUpperCase()),
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            QrImage(
              data: _controller.text,
              version: QrVersions.auto,
              size: 200,
              gapless: false,
            ),
            Padding(
              padding: const EdgeInsets.all(15.0),
              child: TextField(
                decoration: const InputDecoration(
                  hintText: 'Enter Something To Generate Qr Code',
                  border: OutlineInputBorder(),
                ),
                controller: _controller,
              ),
            ),
            ElevatedButton(
              onPressed: () {
                setState(() {});
                showSnackBar(
                  message: 'QrCode Generated Take a Screenshot and Scan.',
                  context: context,
                );
              },
              child: const Text('Generate'),
            ),
          ],
        ),
      ),
    );
  }
}
