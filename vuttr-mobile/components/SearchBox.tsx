import Ionicons from '@expo/vector-icons/Ionicons';
import { Text, TextInput, TouchableOpacity, View } from 'react-native';
import api from 'service/api';

interface SearchBoxProps {
  text: string;
  setText: any;
}

function SearchBox({ text, setText, onSearch }) {
  return (
    <View className="mb-2 h-10 flex-row gap-2">
      <TextInput
        className="flex flex-1 flex-row rounded-md bg-gray-300 p-2 text-sm text-gray-700"
        placeholder="Busca atividade"
        placeholderTextColor="#6b7280"
        value={text}
        onChangeText={(text) => setText(text)}
      />
      <View className="rounded-md bg-gray-300 p-2 ">
        <Text className=" text-sm text-gray-700">Tag</Text>
      </View>

      <TouchableOpacity className="rounded-md bg-gray-300 p-2" onPress={onSearch}>
        <Text className=" text-gray-700">
          <Ionicons name="search" size={16} />
        </Text>
      </TouchableOpacity>
    </View>
  );
}

export default SearchBox;
