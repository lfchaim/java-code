package com.whs.javacode.codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/playground/dZ9nnpKK
 * 
For given list of folders, we need to find out what is the folder path for a given folder id from root.
Root folder id is always zero. no other folder can have zero as there folder ID. there would be multiple path from root folder.
A node can have multiple parents.

folderList = [
	{id: 0, subfolders : [7,3], name: 'abc1'},
	{id: 0, subfolders : [9], name: 'abc2'},
	{id: 9, subfolders : [], name: 'abc3'},
	{id: 3, subfolders : [2], name: 'abc4'},
	{id: 2, subfolders : [], name: 'abc5'},
	{id: 7, subfolders : [], name: 'abc6'},
	{id: 8, subfolders : [], name: 'abc7'}
];
for target folder = 2 it should return

/abc1/abc4/abc5
for target folder 8, it should return "" as it is not reachable from root.
What would be solution. Specially with time complexity.
*/

public class FolderPath {
    
    public static String folderPath(List<Pair> subfoldersList, List<String> folderNames, int folderID){
	
        //map ids to folder names
        Map<Integer, List<String>> folderIDNameMap = new HashMap<>(); 
        for (int i = 0; i < subfoldersList.size(); i++) {
            int fID = subfoldersList.get(i).id; //get the folder ID
            String name = folderNames.get(i); //get the name corresponding to this ID
            //build IdNameMap
            List<String> names = folderIDNameMap.getOrDefault(fID, new ArrayList<>());
            names.add(name);
            folderIDNameMap.put(fID, names);
        }
        
        // build graph
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < subfoldersList.size(); i++) {
            Pair pair = subfoldersList.get(i); //maps a folder ID to a list of its subfolders
            String name = folderNames.get(i); //get the name corresponding to this ID
            List<Integer> subfolders = pair.childFolders; //get its subfolders

            List<String> neighbours = graph.getOrDefault(name, new ArrayList<>());
            for (int subfolderID : subfolders) {
                String subFolderName = folderIDNameMap.get(subfolderID).get(0); //assume that we wil have only one name for any ID other than the root folder. 
                neighbours.add(subFolderName);
            }
            graph.put(name, neighbours);
        }

        String dest = folderIDNameMap.get(folderID).get(0);
        for (String root : folderIDNameMap.get(0)) { //start from each root folder and traverse the graph to find the required folder
            StringBuilder result = new StringBuilder();
            if (dfs(root, dest, new ArrayList<>(), result, graph)) {
                return "/"+result.toString();
            }
        }
        return "";
    }

    //we have not used a visited array assuming no cycles and therefore no back edge from a folder to its parent folder or any folder higher up in the heirarchy from root
    private static boolean dfs(String node, String dest, ArrayList<String> path, StringBuilder result, Map<String, List<String>> graph) {
            if (node.equals(dest)) {
                path.add(node);
                //report to result
                result.append(String.join("/", path));
                path.remove(path.size()-1);    
                return true;
            }
            path.add(node);
            for (String neighbour : graph.get(node)) {
                if (dfs(neighbour, dest, path, result, graph)) {
                    return true;
                }
            }
            path.remove(path.size()-1);
            return false;
        }

    public static void main(String[] args) {
        
        //create pairs of folders to their respective list of subfolders
        List<Pair> subfolderList = new ArrayList<>();
        subfolderList.add(new Pair(0, new ArrayList<>(Arrays.asList(7,3))));
        subfolderList.add(new Pair(0, new ArrayList<>(Arrays.asList(9))));
        subfolderList.add(new Pair(9, new ArrayList<>()));
        subfolderList.add(new Pair(3, new ArrayList<>(Arrays.asList(2))));
        subfolderList.add(new Pair(2, new ArrayList<>()));
        subfolderList.add(new Pair(7, new ArrayList<>()));
        subfolderList.add(new Pair(8, new ArrayList<>()));
        
        //create a list of folder names corresponding to the above list
        List<String> folderNames = new ArrayList<>(Arrays.asList("abc1", "abc2", "abc3", "abc4", "abc5", "abc6", "abc7"));
        
        //call the method
        System.out.println("2 - folder path is : "+folderPath(subfolderList, folderNames, 2));
        System.out.println("8 - folder path is : "+folderPath(subfolderList, folderNames, 8));
        System.out.println("7 - folder path is : "+folderPath(subfolderList, folderNames, 7));
        System.out.println("3 - folder path is : "+folderPath(subfolderList, folderNames, 3));
        System.out.println("9 - folder path is : "+folderPath(subfolderList, folderNames, 9));
        System.out.println("0 - folder path is : "+folderPath(subfolderList, folderNames, 0));
    }
}

class Pair {
	
	Pair(int id, List<Integer> childFolders ) {
		this.id = id;
		this.childFolders = childFolders;
	}
	
	protected int id;
    protected List<Integer> childFolders;
}