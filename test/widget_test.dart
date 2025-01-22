import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:untitled3/main.dart'; // Замените "untitled3" на имя вашего проекта.

void main() {
  testWidgets('Counter increments smoke test', (WidgetTester tester) async {
    // Запускаем приложение.
    await tester.pumpWidget(const MyApp());

    // Проверяем, что текст "0" отображается, а "1" нет.
    expect(find.text('0'), findsOneWidget);
    expect(find.text('1'), findsNothing);

    // Нажимаем на кнопку "+".
    await tester.tap(find.byIcon(Icons.add));
    await tester.pump();

    // Проверяем, что текст изменился с "0" на "1".
    expect(find.text('0'), findsNothing);
    expect(find.text('1'), findsOneWidget);
  });
}
