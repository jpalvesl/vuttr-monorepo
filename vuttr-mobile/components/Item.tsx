import Ionicons from '@expo/vector-icons/Ionicons';
import React from 'react';
import { Text, View } from 'react-native';
import api from 'service/api';

import Tag from './Tag';

interface Props {
  item: any;
  handleDelete: any;
}

function Item({ item, handleDelete }: Props) {
  return (
    <View className="mt-2 rounded-md bg-gray-700 pl-2 pr-2">
      <View className="mb-2 mt-2 flex-row items-center justify-between">
        <Text className="text-4xl text-gray-300">{item.title}</Text>
        <Ionicons name="trash" size={32} color="#d1d5dd" onPress={handleDelete} />
      </View>

      <View className="mb-2 flex-row flex-wrap gap-2">
        {item.tags?.map((tag, idx) => <Tag key={idx} />)}
      </View>
    </View>
  );
}

export default Item;
