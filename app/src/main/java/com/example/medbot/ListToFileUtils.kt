import android.content.Context
import com.example.medbot.MessageModel
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class ListToFileUtils {

    companion object {
        fun saveListToFile(context: Context, fileName: String, list: MutableList<MessageModel>) {
            try {
                // Open a file stream for writing
                val fileOutputStream: FileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
                val outputStreamWriter = OutputStreamWriter(fileOutputStream)

                // Iterate through the list and write each element to the file
                for (item in list) {
                    outputStreamWriter.write("$item\n")
                }

                // Close the streams
                outputStreamWriter.close()
                fileOutputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        // Function to get the path of the saved file
        fun getSavedFilePath(context: Context, fileName: String): String {
            val file: File = File(context.filesDir, fileName)
            return file.absolutePath
        }

        fun logFileContent(context: Context, fileName: String) {
            try {
                // Open a file stream for reading
                val fileInputStream: FileInputStream = context.openFileInput(fileName)
                val inputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader = BufferedReader(inputStreamReader)

                // Read each line of the file and log it
                var line: String?
                while (bufferedReader.readLine().also { line = it } != null) {
                    println(line) // Log the line to the console
                }

                // Close the streams
                bufferedReader.close()
                inputStreamReader.close()
                fileInputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
