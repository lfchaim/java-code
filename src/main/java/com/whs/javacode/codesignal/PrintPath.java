package com.whs.javacode.codesignal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PrintPath {

	public static void main(String[] args) {
		PrintPath pp = new PrintPath();
		// [Folder(0, [7, 3], “abc”), Folder(0, [], “xyz”), Folder(3, [], “pqr”), Folder(8, [], “def”), Folder(7, [9], “ijk), Folder(9, [], “lmn”)]
		pp.addFolder(new Folder(0, "abc", Arrays.asList(7,3)));
		pp.addFolder(new Folder(0,"xyz", Arrays.asList()));
		pp.addFolder(new Folder(3,"pqr", Arrays.asList()));
		pp.addFolder(new Folder(8,"def", Arrays.asList()));
		pp.addFolder(new Folder(7,"ijk", Arrays.asList(9)));
		pp.addFolder(new Folder(9,"lmn", Arrays.asList()));
		System.out.println(pp.getSize());
		System.out.println(pp.getFolderPath(9));
		System.out.println(pp.getFolderPath(8));
	}
	
	private ConcurrentHashMap<Integer,Integer> folderIdToParentFolderId;
	private ConcurrentHashMap<Integer, Folder> idToFolder;

	PrintPath() {
	    folderIdToParentFolderId = new ConcurrentHashMap<>();
	    idToFolder = new ConcurrentHashMap<>();
	}

	public int getSize() {
		return idToFolder.size();
	}
	public void addFolder(Folder folder) {
	    idToFolder.put(folder.id, folder);
	    folder.childFolders.forEach(childId -> folderIdToParentFolderId.put(childId, folder.id));
	}

	public String getFolderPath(int id){
	    StringBuilder path = new StringBuilder();
	    while(idToFolder.contains(id)){
	        Folder folder = idToFolder.get(id);
	        path.append(folder.name + "/");
	        if(folderIdToParentFolderId.contains(id)) id = folderIdToParentFolderId.get(id);
	        else id = -1;
	    }
	    return path.toString();
	}

}

class Folder {
	
	public Folder(int id, String name, List<Integer> childFolders ) {
		this.id = id;
		this.name = name;
		this.childFolders = childFolders;
	}
	
	protected int id;
    protected String name;
    protected List<Integer> childFolders;
}


/*
Given list of folders, print the path of a given folder from root. If there is no path to the root folder then return an empty string. Root level folders will have 0 as id. The structure of Folder is like this:
class Folder {
int id;
List subfolders;
String name;
}


Ex:
list = [Folder(0, [7, 3], “abc”), Folder(0, [], “xyz”), Folder(3, [], “pqr”), Folder(8, [], “def”), Folder(7, [9], “ijk), Folder(9, [], “lmn”)]


/abc/ijk/lmn
/abc/pqr
/xyz
?? def/


printPath(9) = “abc” -> “ijk” -> “lmn” printPath(8) = ""
Clarification: There can be multiple root level folders. All other folders have unique ids.
Note: printPath method may be called multiple times concurrently. Design your solution taking that into account
Concurrency in input and printPath()


addFolder(Folder f)
printPath(int index)
*/