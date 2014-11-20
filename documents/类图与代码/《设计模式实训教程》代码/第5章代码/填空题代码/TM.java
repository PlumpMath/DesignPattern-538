abstract class Document {
	public void save() { /* 存储文档数据，此处代码省略 */}
	public void open(String docName) { /*打开文档，此处代码省略 */}
	public void close() { /* 关闭文档，此处代码省略 */}
	public abstract void read(String docName);
}

abstract class Application {
	private Vector<Document> docs; /*文档对象集合*/
	public boolean canOpenDocument(String docName){
		/*判断是否可以打开指定文档，返回真值时表示可以打开，
		 返回假值表示不可打开，此处代码省略*/
	}
	public void addDocument(Document aDocument){
		/*将文档对象添加到文档对象集合中*/
		docs.add(aDocument);
	}
	public abstract Document doCreateDocument(); /*创建一个文档对象*/
	public void openDocument(String docName) { /*打开文档*/
		if(canOpenDocument(docName)) {
			System.out.println("文档无法打开！");
			return;
		}
		Document adoc = new MyDocument();
		adoc.open(docName);
		adoc.read();
		addDocument(adoc);
	}
}