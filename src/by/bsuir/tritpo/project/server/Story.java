package by.bsuir.tritpo.project.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

/*
 * класс хранящий в ссылочном приватном
 * списке информацию о последних 10 (или меньше) сообщениях
 */
class Story {
    private LinkedList<String> story = new LinkedList<>();
    private LinkedList<String> names = new LinkedList<>();
    /*
     * добавить новый элемент в список
     * @param el
     */
    public void addNames(String name){
        names.add(name);
    }
    public void printNames(BufferedWriter writer){
        if(names.size()>0) {
            try {
                writer.write("Clients:" + "\n");
                for (String vr : names) {
                    writer.write(vr + "\n");
                }
                writer.flush();
            } catch (IOException ignored) {}
        }
        else
            try {
                writer.write("Server is empty :(");
            }catch (IOException ignored){}
    }

    public void addStoryEl(String el) {
        // если сообщений больше 10, удаляем первое и добавляем новое
        // иначе просто добавить
        if (story.size() >= 10) {
            story.removeFirst();
            story.add(el);
        } else
            story.add(el);
    }
    /*
     * отсылаем последовательно каждое сообщение из списка
     * в поток вывода данному клиенту (новому подключению)
     * @param writer
     */
    public void printStory(BufferedWriter writer) {
        if(story.size() > 0) {
            try {
                writer.write("History messages" + "\n");
                for (String vr : story) {
                    writer.write(vr + "\n");
                }
                writer.write("/...." + "\n");
                writer.flush();
            } catch (IOException ignored) {}
        }
    }
}
