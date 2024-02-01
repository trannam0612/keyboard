import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

typedef DisplayViewCallback = void Function(DisplayViewController controller);

class KeyboardWidget extends StatefulWidget {
  const KeyboardWidget({
    super.key,
    this.displayViewCallback,
  });

  final DisplayViewCallback? displayViewCallback;

  @override
  State<KeyboardWidget> createState() => _KeyboardWidgetState();
}

class _KeyboardWidgetState extends State<KeyboardWidget> {
  @override
  Widget build(BuildContext context) {
    if(defaultTargetPlatform == TargetPlatform.android){
      return AndroidView(viewType: "plugins/keyboard_widget",onPlatformViewCreated: ,);
    }
    return Center(
      child: Text('error connecting with android view'),
    );
  }

  void _onPlatformCreated(int id) {
    if(widget.displayViewCallback ==null){
      return;
    }
    widget.displayViewCallback!(DisplayViewController._(id));
  }
}

class DisplayViewController {
  DisplayViewController._(int id)
      : _channel = MethodChannel("plugins/keyboard_widget_$id");
  final MethodChannel _channel;

  Future<Future<List?>> darggable(bool value) async {
    return _channel.invokeListMethod('darggable', value);
  }
}
