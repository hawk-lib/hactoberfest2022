import 'package:flutter/material.dart';
import 'package:velocity_x/velocity_x.dart';

class SearchListScreen extends StatefulWidget {
  const SearchListScreen({super.key});

  @override
  State<SearchListScreen> createState() => _SearchListScreenState();
}

class _SearchListScreenState extends State<SearchListScreen> {
  final TextEditingController searchController = TextEditingController();

  String word = "";

  List<String> lists = [
    "exchange",
    "vex",
    "pain",
    "creepy",
    "cannon",
    "cemetery",
    "berry",
    "brawny",
    "control",
    "hearing",
    "coherent",
    "tremble",
    "nimble",
    "space",
    "face",
    "knot",
    "vary",
    "wind",
    "halting",
  ];

  List<String> searchedLists = [];

  searchData(String value) {
    searchedLists = lists.where((element) {
      return element.toLowerCase().contains(value.toLowerCase());
    }).toList();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: PreferredSize(
        preferredSize: const Size.fromHeight(80),
        child: AppBar(
          title: VxTextField(
            hint: "Search...",
            fillColor: Colors.white.withOpacity(0.5),
            controller: searchController,
            borderRadius: 10,
            prefixIcon: const Icon(Icons.search),
            borderType: VxTextFieldBorderType.roundLine,
            onChanged: (value) {
              setState(() {
                searchData(value);
              });
            },
          ),
        ),
      ),
      body: searchController.text.isNotEmpty && searchedLists.isEmpty
          ? "No Results Found!!!".text.xl.makeCentered()
          : ListView.separated(
              shrinkWrap: true,
              itemCount: searchController.text.isNotEmpty
                  ? searchedLists.length
                  : lists.length,
              separatorBuilder: (context, index) {
                return const VxDivider();
              },
              itemBuilder: ((context, index) {
                return searchController.text.isNotEmpty
                    ? searchedLists[index]
                        .text
                        .lg
                        .make()
                        .pSymmetric(v: 20, h: 15)
                    : lists[index].text.lg.make().pSymmetric(v: 20, h: 15);
              }),
            ),
    );
  }
}
